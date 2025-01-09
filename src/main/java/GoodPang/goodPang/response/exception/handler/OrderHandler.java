package GoodPang.goodPang.response.exception.handler;

import GoodPang.goodPang.response.exception.GeneralException;
import GoodPang.goodPang.response.fail.BaseErrorCode;

public class OrderHandler extends GeneralException {
    public OrderHandler(BaseErrorCode code) {
        super(code);
    }
}
