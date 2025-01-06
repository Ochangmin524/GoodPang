package GoodPang.goodPang.response.exception.handler;

import GoodPang.goodPang.response.exception.GeneralException;
import GoodPang.goodPang.response.fail.BaseErrorCode;

public class LikedItemHandler extends GeneralException {
    public LikedItemHandler(BaseErrorCode code) {
        super(code);
    }
}
