package algorithm.hackerrank.practice.numbers;

import org.junit.Assert;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;

public class isProbablePrime {
	public static void main(String[] args){
		Assert.assertThat(new BigInteger("1").isProbablePrime(1), is(false));
		Assert.assertThat(new BigInteger("2").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("3").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("5").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("7").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("11").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("13").isProbablePrime(1), is(true));
		Assert.assertThat(new BigInteger("2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983").isProbablePrime(1), is(true));
	}
}
