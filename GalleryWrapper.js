import { CommonGalleryWrapper } from '@wix/common-pro-gallery-component-wrapper';
import loadable from '@wix/yoshi-flow-editor/loadable';
import ProFullscreenWrapper from '../FullscreenWrapper/FullscreenWrapper'; // TODO - remove FullscreenWrapper import when the SSR can accept different bundles
import { PRO_GALLERY } from '../../../../types/constants';
import { getResizeMediaUrl } from '@wix/photography-client-lib';
import '../../../../assets/static/commonStaticsCss.global.scss';
import '../../../../assets/static/proGallery/FullscreenWrapper.scss';
import '../../../../assets/static/common/galleryEmpty.scss';
// import '../../../../assets/dynamic/proGallery/FullscreenWrapperWixStyles.scss'

export default class ProGalleryWrapper extends CommonGalleryWrapper {
  isStoreGallery() {
    return false;
  }

  createStaticCssLinkElement() {
    return null;
  }

  getFullscreenElementIfNeeded() {
    if (!this.canRenderFullscreen()) {
      return null;
    }
    if (typeof ProFullscreenWrapper !== 'undefined') {
      return ProFullscreenWrapper;
    } else if (!this.FullscreenWrapper) {
      this.FullscreenWrapper = loadable(() =>
        import(
          /* webpackChunkName: "FullscreenWrapper" */ '../FullscreenWrapper/FullscreenWrapper'
        ),
      );
    }
    return this.FullscreenWrapper || null;
  }

  canRenderFullscreen() {
    return this.getFullscreenSelectedIndex() >= 0;
  }

  getSentryDSN() {
    return PRO_GALLERY.SENTRY_DSN;
  }

  getItemResizer(staticMediaUrls, isPrerenderMode) {
    return getResizeMediaUrl({
      staticMediaUrls,
      isPrerenderMode,
      useOptimizedImageFormat: this.props.options?.useOptimizedImageFormat,
    });
  }

  getGalleryEmptyDynamically() {
    import(/* webpackChunkName: "galleryEmpty" */ './galleryEmpty').then(
      (module) => {
        this.galleryEmptyComponent = module.default;
        this.setState({ galleryEmptyComponentLoaded: true });
      },
    );
  }
  getGalleryEmpty() {
    if (!this.galleryEmptyComponent) {
      this.getGalleryEmptyDynamically();
      return null;
    }
    return this.galleryEmptyComponent;
  }
}
