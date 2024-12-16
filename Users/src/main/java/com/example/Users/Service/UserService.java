package com.example.Users.Service;

import com.example.Users.Entity.users;
import com.example.Users.Repository.UserRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUserName(String username) {
        users user = userRepository.findByUsername(username);

        if (null != user) {
            System.out.println("get user list:" + username + "_claim");
            List<users> userWithClaim = userRepository.getUsers(username + "_claim");
            if (null != userWithClaim && !userWithClaim.isEmpty()) {
                // get max username and then increase the counter
                List<Integer> num = new ArrayList<>();
                for (users userInfo : userWithClaim) {
                    Integer count = getCount(userInfo.getUsername());
                    num.add(count);
                }
                Integer max = Collections.max(num);
                username = username + "_claim" + max++;
            }
        }
        return username;
    }

    private Integer getCount(String username) {
        final Pattern lastIntPattern = Pattern.compile("[^0-9]+([0-9]+)$");
        int lastNumberInt = 0;
        Matcher matcher = lastIntPattern.matcher(username);
        if (matcher.find()) {
            String someNumberStr = matcher.group(1);
            lastNumberInt = Integer.parseInt(someNumberStr);
        }
        return lastNumberInt;
    }
}
