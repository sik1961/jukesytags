# jukesytags

sik@Mac-mini jukesytags % xattr -h
usage: xattr [-l] [-r] [-s] [-v] [-x] file [file ...]
xattr -p [-l] [-r] [-s] [-v] [-x] attr_name file [file ...]
xattr -w [-r] [-s] [-x] attr_name attr_value file [file ...]
xattr -d [-r] [-s] attr_name file [file ...]
xattr -c [-r] [-s] file [file ...]

The first form lists the names of all xattrs on the given file(s).
The second form (-p) prints the value of the xattr attr_name.
The third form (-w) sets the value of the xattr attr_name to the string attr_value.
The fourth form (-d) deletes the xattr attr_name.
The fifth form (-c) deletes (clears) all xattrs.

options:
-h: print this help
-l: print long format (attr_name: attr_value and hex output has offsets and
ascii representation)
-r: act recursively
-s: act on the symbolic link itself rather than what the link points to
-v: also print filename (automatic with -r and with multiple files)
-x: attr_value is represented as a hex string for input and output
sik@Mac-mini jukesytags %

https://apple.stackexchange.com/questions/106109/any-way-to-set-add-tags-on-a-file-with-applescript-under-mavericks 


