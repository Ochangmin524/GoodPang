package GoodPang.goodPang.response.fail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode{
    //가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403","금지된 요청입니다."),

    //멤버 관련 에러
    _DUPLICATED_LOGIN_ID(HttpStatus.BAD_REQUEST,"MEM001" ,"이미 존재하는 로그인 아이디 입니다."),
    _MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEM002" ,"존재하지 않는 회원입니다."),

    //상품 관련 예러
    _CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "ITEM001", "존재하지 않는 카테고리입니다."),
    _ITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "ITEM002", "존재하지 않는 상품입니다."),
    _OUT_OF_STOCK(HttpStatus.BAD_REQUEST, "ITEM003", "제품 수량이 부족합니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    //실패 응답 생성.
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    //http상태를 담은 실패 응답 생성
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
