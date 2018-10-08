package algorithm.hackerrank.practice.strings;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

public class UsernameRegular {
	public static void main(String[] args){
		String regex = "^[a-zA-Z]\\w{7,29}";
		Assert.assertThat("Julia".matches(regex), is(false));
		Assert.assertThat("Samantha".matches(regex), is(true));
		Assert.assertThat("SamanthaSamanthaSamanthaSamant".matches(regex), is(true));
		Assert.assertThat("Samantha_21".matches(regex), is(true));
		Assert.assertThat("1Samantha".matches(regex), is(false));
		Assert.assertThat("Samantha?10_2A".matches(regex), is(false));
		Assert.assertThat("JuliaZ007".matches(regex), is(true));
		Assert.assertThat("Julia@007".matches(regex), is(false));
		Assert.assertThat("_Julia007".matches(regex), is(false));
	}
}
