import {
    StyleParamType,
    wixColorParam,
    wixFontParam,
    createStylesParams,
  } from '@wix/tpa-settings';
  
  export type IStylesParams = {
    backgroundColor: StyleParamType.Color;
    textFont: StyleParamType.Font;
    textColor: StyleParamType.Color;
  };
  
  export default createStylesParams<IStylesParams>({
    backgroundColor: {
      type: StyleParamType.Color,
      getDefaultValue: wixColorParam('color-3'),
    },
    textFont: {
      type: StyleParamType.Font,
      getDefaultValue: wixFontParam('Body-M', {
        size: 20,
      }),
    },
    textColor: {
      type: StyleParamType.Color,
      getDefaultValue: wixColorParam('color-5'),
    },
  });
  