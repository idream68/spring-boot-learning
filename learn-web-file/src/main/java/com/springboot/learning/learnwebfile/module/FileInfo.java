package com.springboot.learning.learnwebfile.module;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileInfo {
    long size;
    String name;
}
