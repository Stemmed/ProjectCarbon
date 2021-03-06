package dev.brighten.db.utils.security.hash.impl;

import dev.brighten.db.utils.security.GeneralUtils;
import dev.brighten.db.utils.security.hash.Hash;
import dev.brighten.db.utils.security.hash.HashType;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA2 extends Hash {

    public SHA2() {
        super(HashType.SHA2);
    }

    public String hash(String toHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    toHash.getBytes(StandardCharsets.UTF_8));

            return GeneralUtils.bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return toHash;
    }

    public boolean hashEqualsKey(String hash, String key) {
        return hash.equals(hash(key));
    }
}
