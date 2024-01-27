package Board.bt.utils;

import Board.bt.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        if(!StringUtils.hasText(member.getUserId()) || member.getUserId().length() < 5){
//            bindingResult
//                    .addError(new FieldError("member","userId",member.getUserId(),false,new String[]{"required.member.userId"},null,null));
            errors.rejectValue("userId","noHanguel");
        }
        if(member.getAge() == 0 || member.getAge() > 100){
//            bindingResult
//                    .addError(new FieldError("member", "age",member.getAge(), false, new String[]{"max.member.age"},new Object[]{100},null));
            errors.rejectValue("age","max",new Object[]{100}, null);
        }

        if(member == null){
            errors
                    .reject("loginFail", "아이디 또는 패스워드를 확인해주세요.2222");
        }
    }
}
