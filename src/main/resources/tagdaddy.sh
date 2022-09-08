#!/bin/bash
dir="$1"

for file in $(find .)
do
    echo "${file%.*}"
    filetags=$(xattr -pl com.apple.metadata:_kMDItemUserTags $file)

    echo "$filetags"

    if [ -n "$filetags" ]
    then
          xattr -w com.apple.metadata:_kMDItemUserTags $filetags $dir
    fi
done
exit 0