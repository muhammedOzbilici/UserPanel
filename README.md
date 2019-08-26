Spring Boot ve MongoDb (Embedded) ile geliştirilmiş kullanıcı yönetim paneli.

Veritabanında kayıtlı kullanıcılar güncellenebilir, silinebilir ya da yeni kullanıcı eklenebilir.

docker için;
```
docker build -f Dockerfile -t user-panel .
docker pull mongo
docker run -p 8484:8484 user-panel

```