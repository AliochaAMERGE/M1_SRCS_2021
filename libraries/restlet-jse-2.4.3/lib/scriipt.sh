#/bin/bash

path_target=$(dirname $0)
cd $path_target
path_target=$(pwd)

for f in * ; do
  if ! [ -d $f ] ; then
      continue
  fi
  cd $f
  for jar in *.jar ; do
    rm -f "$path_target/$jar"
    ln -s "$pwd/$jar" "$path_target/$jar"
  done
  cd $pathh_target
done
