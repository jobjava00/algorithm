package algorithm.hackerrank.practice.strings;

import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

/**
 *  중복 단어 제거
 */
public class DuplicateWords {
	public String solution(String input){
		String regex = "\\b(\\w+)(\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);

		while (m.find()) {
			input = input.replaceAll(m.group(), m.group(1));    //전체 일치 항목 중에 첫번째 일치하는 것으로 바꿔줌
		}

		System.out.println(input);
		return input;
	}

	public static void main(String[] args) {
		DuplicateWords question = new DuplicateWords();
		Assert.assertThat(question.solution("Goodbye bye bye world world world"), is("Goodbye bye world"));
		Assert.assertThat(question.solution("Sam went went to to to his business"), is("Sam went to his business"));
		Assert.assertThat(question.solution("Reya is is the the best player in eye eye game"), is("Reya is the best player in eye game"));
		Assert.assertThat(question.solution("in inthe"), is("in inthe"));
		Assert.assertThat(question.solution("Hello hello Ab aB"), is("Hello Ab"));
	}
}
