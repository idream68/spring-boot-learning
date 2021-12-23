package com.java.learning.shiro.base;

import org.apache.shiro.crypto.hash.*;

public class TestMd5Hash {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());
        Md5Hash md5Hash1 = new Md5Hash("123", "sadgh9034#");
        System.out.println(md5Hash1.toHex());
        // 明文，盐，散列次数
        Md5Hash md5Hash2 = new Md5Hash("123", "asdgh9034#", 1024);
        System.out.println(md5Hash2.toHex());
        Sha1Hash sha1Hash = new Sha1Hash("123");
        System.out.println(sha1Hash.toHex());
        Sha1Hash sha1Hash1 = new Sha1Hash("123", "abcde" );
        System.out.println(sha1Hash1.toHex());
        Sha1Hash sha1Hash2 = new Sha1Hash("123", "abcde", 1024);
        System.out.println(sha1Hash2.toHex());
        Sha256Hash sha256Hash = new Sha256Hash("123");
        System.out.println(sha256Hash.toHex());
        Sha384Hash sha384Hash = new Sha384Hash("123");
        System.out.println(sha384Hash.toHex());
        Sha512Hash sha512Hash = new Sha512Hash("123");
        System.out.println(sha512Hash.toHex());
        Sha512Hash sha512Hash1 = new Sha512Hash("123", "asdgh9034#");
        System.out.println(sha512Hash1.toHex());
        Sha512Hash sha512Hash2 = new Sha512Hash("123", "asdgh9034#", 1024);
        System.out.println(sha512Hash2.toHex());
    }
}
