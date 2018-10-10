package algorithm.hackerrank.practice.strings;

import static org.hamcrest.CoreMatchers.is;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

/**
 *  중복 단어 제거
 */
public class TagContentExtractor {
	public String solution(String input){
		String regex = "<(.+)>([^<]+)</\\1>";

		boolean matchFound = false;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		String output = "";

		while (m.find()) {
			input = m.group(2);
			output += input;
			System.out.println(output);
			matchFound = true;
		}

		if(!matchFound){
			output = "None";
			System.out.println(output);
		}
		return output;
	}

	public static void main(String[] args) {
		TagContentExtractor question = new TagContentExtractor();
		Assert.assertThat(question.solution("<h1>Nayeem loves counseling</h1>"), is("Nayeem loves counseling"));
		Assert.assertThat(question.solution("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"), is("Sanjay has no watchSo wait for a while"));
		Assert.assertThat(question.solution("<Amee>safat codes like a ninja</amee>"), is("None"));
		Assert.assertThat(question.solution("<SA premium>Imtiaz has a secret crush</SA premium>"), is("Imtiaz has a secret crush"));
	}
}
