package com.lankajob.lankajob.bootstrap;


import com.lankajob.lankajob.entity.Job;
import com.lankajob.lankajob.entity.User;
import com.lankajob.lankajob.repository.JobRepository;
import com.lankajob.lankajob.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrapdata implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;

    @Override
    public void run(String... args) throws Exception {

//        User sachith = new User();
//        sachith.setfName("sachith");

//        userRepository.save(sachith);

//        Job job =new Job("SE","IT",350000,"Colombo","2021/11/12","SE");
//        jobRepository.save(job);
//

//        System.out.println(userRepository.count()+" Users added");

    }
}
