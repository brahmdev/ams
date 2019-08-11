package com.dev.ams.resource;

import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dev.ams.model.Authorities;
import com.dev.ams.model.ParentDetails;
import com.dev.ams.model.StudentDetails;
import com.dev.ams.model.Users;
import com.dev.ams.repository.UserRepository;
import com.dev.ams.utils.AWSUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UsersResource {

    @Autowired
    UserRepository userRepository;

    private static final String S3_BUCKET_NAME = "devarena-ams";

    @RequestMapping(value = "/parent/{username}", method = RequestMethod.GET)
    public Optional<Users> getParentDetails(@PathVariable String username) {
        Optional<Users> studentUser = userRepository.findByUserName(username);
        Optional<Users> parentUser = null;
        Set<StudentDetails> studentDetails;
        Set<ParentDetails> parentDetails;

        if (studentUser.isPresent()) {
            studentDetails = userRepository.findStudentDetailsById(studentUser.get().getId());
            if (studentDetails.iterator().hasNext()) {
                String parentUserName = studentDetails.iterator().next().getParentsUsername();
                parentUser = userRepository.findByUserName(parentUserName);
                if (parentUser.isPresent()) {
                    parentDetails = userRepository.findParentDetailsById(parentUser.get().getId());
                    parentUser.get().setParentDetailses(parentDetails);
                }
            }
        }
        return parentUser;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Optional<Users> getUserDetails(@PathVariable String username) {
        return userRepository.findByUserName(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{branchId}/{type}", method = RequestMethod.GET)
    public Iterable<Users> getUsersByType(@PathVariable Integer branchId, @PathVariable String type) {
        return userRepository.findByUsersByType(branchId, type);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Users saveOrUpdateUser(@RequestBody Users user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (user.getStudentDetailses().iterator().hasNext()) {
            user.getStudentDetailses().iterator().next().setUsers(user);
        }

        if (user.getAuthoritieses().iterator().hasNext()) {
            user.getAuthoritieses().iterator().next().setUsers(user);
        }

        if (user.getParentDetailses().iterator().hasNext()) {
            user.getParentDetailses().iterator().next().setUsers(user);
        }
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer userId) {
        Optional<Users> user = userRepository.findByUserId(userId);
        String userName = user.get().getUsername();
        AWSUtils.getAmazonS3Client().deleteObject(S3_BUCKET_NAME, "test/avatar/" + userName + ".png");
        AWSUtils.getAmazonS3Client().deleteObject(S3_BUCKET_NAME, "test/signature/" + userName + ".png");

        userRepository.deleteUserById(userId);
    }

    @RequestMapping(value = "/{username}/authorities", method = RequestMethod.GET)
    public Iterable<Authorities> getAuthorityByUserName(@PathVariable String username) {
        return userRepository.findAllAuthoritiesByUsername(username);
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public @ResponseBody
    void uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename() + ".png";
            InputStream targetStream = new ByteArrayInputStream(bytes);

            Long contentLength = Long.valueOf(bytes.length);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(contentLength);

            PutObjectRequest putObjectRequest = new PutObjectRequest(S3_BUCKET_NAME, "test/avatar/" + fileName, targetStream, metadata);
            AccessControlList acl = new AccessControlList();
            acl.grantPermission(GroupGrantee.AllUsers, Permission.Read); //all users or authenticated
            putObjectRequest.setAccessControlList(acl);
            AWSUtils.getAmazonS3Client().putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/uploadBase64Image/{fileName}", method = RequestMethod.POST)
    public @ResponseBody
    void uploadBase64Image(@RequestBody String imageValue, @PathVariable String fileName) {
        try {
            String base64Image = imageValue.split(",")[1];

            byte[] imageByte = Base64.decodeBase64(base64Image);

            InputStream targetStream = new ByteArrayInputStream(imageByte);

            Long contentLength = Long.valueOf(imageByte.length);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(contentLength);

            PutObjectRequest putObjectRequest = new PutObjectRequest(S3_BUCKET_NAME, "test/signature/" + fileName + ".png", targetStream, metadata);
            AccessControlList acl = new AccessControlList();
            acl.grantPermission(GroupGrantee.AllUsers, Permission.Read); //all users or authenticated
            putObjectRequest.setAccessControlList(acl);
            AWSUtils.getAmazonS3Client().putObject(putObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
