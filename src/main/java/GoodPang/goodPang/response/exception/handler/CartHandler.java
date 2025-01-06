package GoodPang.goodPang.response.exception.handler;

import GoodPang.goodPang.response.exception.GeneralException;
import GoodPang.goodPang.response.fail.BaseErrorCode;

public class CartHandler extends GeneralException {
    public CartHandler(BaseErrorCode code) {
        super(code);
    }
}
