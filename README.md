## Spring Boot ve MongoDb (Embedded) ile geliştirilmiş kullanıcı yönetim paneli.


Veritabanında kayıtlı kullanıcılar güncellenebilir, silinebilir ya da yeni kullanıcı eklenebilir.

docker için;
```
docker build -f Dockerfile -t user-panel .
docker pull mongo
docker run -p 8484:8484 user-panel

```

###
Ekran görüntüleri


![alt text](https://user-images.githubusercontent.com/7340804/63693141-f1540b80-c81b-11e9-98e8-651481c2c482.png)

![alt text](https://user-images.githubusercontent.com/7340804/63693142-f1540b80-c81b-11e9-8c4c-a8caaefb4d77.png)

![alt text](https://user-images.githubusercontent.com/7340804/63693144-f1540b80-c81b-11e9-9795-b2bde7f27819.png)

![alt text](https://user-images.githubusercontent.com/7340804/63693145-f1eca200-c81b-11e9-992a-3e188e932215.png)
