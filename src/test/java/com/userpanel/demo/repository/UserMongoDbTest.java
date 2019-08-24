package com.userpanel.demo.repository;

import com.userpanel.demo.service.impl.UserServiceImpl;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMongoDbTest {

    @Autowired
    private UserServiceImpl userService;

    static MongodExecutable mongodExecutable;

    @BeforeClass
    public static void setup() throws Exception {
        MongodStarter mongodStarter = MongodStarter.getDefaultInstance();

        String bindIp = "localhost";
        int port = 12345;
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(bindIp, port, Network.localhostIsIPv6()))
                .build();
        mongodExecutable = null;
        try {
            mongodExecutable = mongodStarter.prepare(mongodConfig);
            mongodExecutable.start();
        } catch (Exception e) {
            if (mongodExecutable != null)
                mongodExecutable.stop();
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (mongodExecutable != null)
            mongodExecutable.stop();
    }

}
