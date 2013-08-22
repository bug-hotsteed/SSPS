# It's a java socket server provides socket policy file for Flash Player on port 843.

## Description
Really a simple java socket server prints :
<cross-domain-policy>
    <allow-access-from domain="*" to-ports="*"/>
</cross-domain-policy>

on port 843 for Flash Player socket connection.

## How to use
In my case :
$nohup java -jar ssps.jar &

That's all.