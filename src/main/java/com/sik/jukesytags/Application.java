package com.sik.jukesytags;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.plist.BplistReader;
import com.drew.metadata.xmp.XmpReader;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.boris.pecoff4j.PE;
import org.boris.pecoff4j.ResourceDirectory;
import org.boris.pecoff4j.ResourceEntry;
import org.boris.pecoff4j.constant.ResourceType;
import org.boris.pecoff4j.io.PEParser;
import org.boris.pecoff4j.io.ResourceParser;
import org.boris.pecoff4j.resources.StringFileInfo;
import org.boris.pecoff4j.resources.StringTable;
import org.boris.pecoff4j.resources.VersionInfo;
import org.boris.pecoff4j.util.ResourceHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String... args) {
        File folder = new File("/Volumes/MacData/sik/Pictures/2018/2018-07-08/");


        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getAbsoluteFile());

                try {

                    Metadata metadata = new Metadata();
//                    FileSystemMetadataReader fsmr = new FileSystemMetadataReader();
//                    fsmr.read(file,metadata);
//
//                    for (Directory directory : metadata.getDirectories()) {
//                        for (Tag tag : directory.getTags()) {
//                            System.out.println(tag);
//                        }
//                    }

//                    if (file.getAbsolutePath().endsWith(".xmp")) {
//                        XmpReader xmpr = new XmpReader();
//                        xmpr.extract(Files.readString(file.toPath()), metadata);
//                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + metadata.toString());
//                        for (Directory directory : metadata.getDirectories()) {
//                            for (Tag tag : directory.getTags()) {
//                                System.out.println(tag);
//                            }
//                        }
//                    }

//                    PE pe = PEParser.parse(file.getAbsoluteFile());
//                    ResourceDirectory rd = pe.getImageData().getResourceTable();
//
//                    ResourceEntry[] entries = ResourceHelper.findResources(rd, ResourceType.STRING_TABLE);
//                    for (int i = 0; i < entries.length; i++) {
//                        byte[] data = entries[i].getData();
//                        VersionInfo version = ResourceParser.readStringTable(data);
//
//                        StringFileInfo strings = version.getStringFileInfo();
//                        StringTable table = strings.getTable(0);
//                        for (int j = 0; j < table.getCount(); j++) {
//                            String key = table.getString(j).getKey();
//                            String value = table.getString(j).getValue();
//                            System.out.println(">>>>>>> " + key + " = " + value);
//                        }
//                    }

                    BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    BasicFileAttributes view
                            = Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class)
                            .readAttributes();

                    UserDefinedFileAttributeView udfav = Files.getFileAttributeView(file.toPath().toAbsolutePath(), UserDefinedFileAttributeView.class);
                    if (udfav != null) {
                        udfav.list().stream().forEach(System.out::println);
                    }

//                    try {
//                        final ImageMetadata metadata = Imaging.getMetadata(file);
//                        for (ImageMetadata.ImageMetadataItem imi : metadata.getItems()) {
//                            System.out.println(">>>> imi>" + imi);
//
//                        }
//                    } catch (IllegalArgumentException e) {
//                        System.out.println("Warn: No image metadata present");
//                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }





    }
}
