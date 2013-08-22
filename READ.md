# SSPS : Simple Socket Policy Server

## Description
It's a java socket server prints a simple socket policy file when Flash Player socket connects on port 843.

``` XML
<cross-domain-policy>
    <allow-access-from domain="*" to-ports="*"/>
</cross-domain-policy>
```

## How to Use

In my case :

``` bash
nohup java -jar ssps.jar &
```

That's all.