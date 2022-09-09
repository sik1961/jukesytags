#! /usr/bin/env python
# -*- coding: utf-8 -*-

""" Write tags to file
Usage:
    tagfile.py "TagName" FileName1 FileName2

    You can use wildcards for the file name. Use quotes if spaces in tags.
    To check if it worked, use xattr -l FileName

"""

import sys
import subprocess

def writexattrs(F,TagList):
    """ writexattrs(F,TagList):
    writes the list of tags to three xattr fields on a file-by file basis:
    "kMDItemFinderComment","_kMDItemUserTags","kMDItemOMUserTags
    Uses subprocess instead of xattr module. Slower but no dependencies"""

    result = ""

    plist_hdr = '<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd"><plist version="1.0"><array>'
    plist_tlr = '</array></plist>'
    plist_tag = ''
    for Tag in TagList:
        plist_tag = plist_tag + '<string>{}</string>'.format(Tag.replace("'","-"))
    tag_text = plist_hdr + plist_tag + plist_tlr

    optional_tag = "com.apple.metadata:"
    xattr_list = ["kMDItemFinderComment","_kMDItemUserTags","kMDItemOMUserTags"]
    for Field in xattr_list:
        xattr_command = 'xattr -w {0} \'{1}\' "{2}"'.format(optional_tag + Field,tag_text.encode("utf8"),F)
        if DEBUG:
            sys.stderr.write("XATTR: {}\n".format(xattr_command))
        proc_out = subprocess.check_output(xattr_command, stderr=subprocess.STDOUT,shell=True)
        result += proc_out
    return result

DEBUG = False


if __name__ == "__main__":
    if len(sys.argv) < 3:
        print __doc__
    else:
        TagList = [ sys.argv[1] ]
        # print TagList
        # Or you can hardwire your tags here
        # TagList = ['Orange','Green']
        FileList = sys.argv[2:]

        for FileName in FileList:
            writexattrs(FileName, TagList)