package test.service.impl;

import org.springframework.stereotype.Service;

import test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Override
	public String test() {
		System.out.println("spring action controlled");
		return null;
	}

	public TestServiceImpl() {
		super();
	}

}
