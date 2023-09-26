package com.lililli.restfull.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>(); // User 객체를 저장할 ArrayList 생성

    private static int userCnt = 3;

    static {
        users.add(new User(1, "mkp", new Date())); // 초기 사용자 데이터 추가
        users.add(new User(2, "kan", new Date()));
        users.add(new User(3, "ldk", new Date()));
    }

    public List<User> findAll() {
        return users; // 모든 사용자 데이터 반환
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCnt);

        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) { // 사용자 데이터를 하나씩 확인
            if (user.getId() == id) { // 주어진 id와 일치하는 사용자 데이터를 찾으면
                return user; // 해당 사용자 데이터 반환
            }
        }
        return null; // 일치하는 사용자 데이터가 없으면 null 반환
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
