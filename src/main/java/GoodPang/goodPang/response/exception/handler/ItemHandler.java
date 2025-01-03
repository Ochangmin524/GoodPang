package GoodPang.goodPang.response.exception.handler;

import GoodPang.goodPang.response.exception.GeneralException;
import GoodPang.goodPang.response.fail.BaseErrorCode;

public class ItemHandler extends GeneralException {
    public ItemHandler(BaseErrorCode code) {
        super(code);
    }
}
