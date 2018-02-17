### Setup

On server
Add the creditapp.service file to the folder below
/etc/systemd/system/ 

Add the creditappservice.sh script file to the folder below
 /usr/local/bin/ 
 
 Modify the SERVICE_NAME, PATH_TO_JAR, and choose a PID_PATH_NAME for the file you are going to use to store your service ID.
 Write the file and give execution permisions ex. sudo chmod +x /usr/local/bin/creditapp.sh