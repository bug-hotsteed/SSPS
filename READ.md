# SSPS : Simple Socket Policy Server

## Description
It's a java socket server provides a simple socket policy file for Flash Player on port 843.

``` XML
<cross-domain-policy>
    <allow-access-from domain="*" to-ports="*"/>
</cross-domain-policy>
```

on port 843 for Flash Player socket connection.

## How to Use

In my case :

``` bash
nohup java -jar ssps.jar &
```

That's all.