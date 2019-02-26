package com.andela.membership.exceptoin;

public class PlanNotFoundException extends RuntimeException {

	public PlanNotFoundException(Long planId) {
		super("Cant't find plan with id:" + planId);
	}

}
