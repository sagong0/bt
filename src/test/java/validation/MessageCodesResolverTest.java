package validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodeResolver에러코드보기_Object(){
        String[] codes = codesResolver.resolveMessageCodes("required", "member");
        assertThat(codes).containsExactly("required.member","required");
    }

    @Test
    void messageCodeResolver에러코드보기_Field(){
        String[] codes = codesResolver.resolveMessageCodes("max", "member", "age", int.class);
        assertThat(codes).containsExactly("max.member.age", "max.age", "max.int", "max");
    }
}
