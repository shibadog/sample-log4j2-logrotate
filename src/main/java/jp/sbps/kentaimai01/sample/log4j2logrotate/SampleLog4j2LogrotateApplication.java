package jp.sbps.kentaimai01.sample.log4j2logrotate;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class SampleLog4j2LogrotateApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleLog4j2LogrotateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		IntStream.generate(ThreadLocalRandom.current()::nextInt)
				.forEach(i -> {
					try {
						TimeUnit.SECONDS.sleep(1L);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					log.info(i);
				});
	}

}
