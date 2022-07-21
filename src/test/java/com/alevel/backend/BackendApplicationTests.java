package com.alevel.backend;

import com.alevel.backend.domain.RecommendRepository;
import com.alevel.backend.domain.RecommendRepositorySupport;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private RecommendRepository recommendRepository;

	@Autowired
	private RecommendRepositorySupport recommendRepositorySupport;

	@After
	public void tearDown() throws Exception {
		recommendRepository.deleteAllInBatch();
	}

	@Test
	public void 타입비교_기능_확인(){
		//given
		String name ="abc";
		String type ="양주";
		String category="고량주어쩌구.."
	}
}
