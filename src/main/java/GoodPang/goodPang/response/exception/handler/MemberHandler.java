package GoodPang.goodPang.response.exception.handler;

import GoodPang.goodPang.response.exception.GeneralException;
import GoodPang.goodPang.response.fail.BaseErrorCode;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
