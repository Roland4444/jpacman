#! /bin/sh
for i in *.rpm; do
    		rpmextract.sh  $i  
			rm $i
done

for i in *.tar.gz; do
    		tar xf  $i 
			rm $i			
done
