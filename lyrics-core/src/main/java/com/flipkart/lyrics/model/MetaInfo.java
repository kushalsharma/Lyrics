package com.flipkart.lyrics.model;

/**
 * @author shrey.garg on 23/12/16.
 */
public class MetaInfo {
    private final String className;
    private final String fullPackage;

    public MetaInfo(String className, String fullPackage) {
        this.className = className;
        this.fullPackage = fullPackage;
    }

    public String getClassName() {
        return className;
    }

    public String getFullPackage() {
        return fullPackage;
    }
}
