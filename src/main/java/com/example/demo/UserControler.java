package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
public class UserControler {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/select")
    public Object select() {

        return userDao.findAll();
    }


    @RequestMapping("/save")
    public List<User> save() {
        User user = new User();
        user.setNumber("15646");
        user.setType(1);
        user.setCreate_date(new Date());
        userDao.save(user);
        Long i = userDao.count();
        System.out.println(i);
        List<User> list = userDao.findByTypeAndNumber(1, "15646");
        System.out.println("sssssssssss::::" + list.size());


        return list;
    }

//
//    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        map.put("wuyihua", 20);
//
//        map.put("kexiwang", 21);
//
//        map.put("luxiaohu", 25);
//
//        Set<Map.Entry<String, Integer>> set = map.entrySet();// 取得键值对的对象set集合
//
//        for (Map.Entry<String, Integer> en : set) {// 遍历键值对的集合
//
//            System.out.println(en.getValue() + "       ");// 通过键值对对象，取得里面的值
//
//        }
//    }

//    public static void main(String[] args) {
//        List<Map> list1 = new ArrayList<>();
//        Map<String, Object> map = new HashMap();
//        map.put("tables", "aaaaa");
//        map.put("id", 1111);
//        list1.add(map);
//        for (int i = 0; i < list1.size(); i++) {
//            Map<String, Object> map1 = list1.get(i);
//            Set<Map.Entry<String, Object>> set = map1.entrySet();
//            int a = 0;
//            for (Map.Entry<String, Object> en : set) {// 遍历键值对的集合
//                if (a==0){
//                    System.out.println(en.getValue() + "   表名    ");// 通过键值对对象，取得里面的值
//                }else if (a==1){
//                    System.out.println(en.getValue() + "   id    ");// 通过键值对对象，取得里面的值
//                }else {
//                    System.out.println(en.getValue() + "   错误    ");// 通过键值对对象，取得里面的值
//                }
//                a++;
//            }
////            System.out.println(set.size());
//
//
//        }
//    }


    public static void main(String[] args) throws UnknownHostException {
       InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(Arrays.toString(inetAddress.getAddress()));
        System.out.println(inetAddress.getCanonicalHostName());
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }


}
