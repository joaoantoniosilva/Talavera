
function registerListener() {
    window.wixDevelopersAnalytics.register(
      'cf06bdf3-5bab-4f20-b165-97fb723dac6a',
      (eventName, eventParams, options) => {
        const XSRFToken = getXSRFTokenFromCookie()
        fetch(
          `${window.location.origin}/_serverless/analytics-reporter/facebook/event`,
          {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
              'X-XSRF-TOKEN': XSRFToken,
            },
            body: JSON.stringify({ eventName, data: eventParams }),
          },
        );
      },
    );
    function getXSRFTokenFromCookie() {
      var match = document.cookie.match(new RegExp("XSRF-TOKEN=(.+?);"));
      return match ? match[1] : "";
    }
  }
  window.wixDevelopersAnalytics
    ? registerListener()
    : window.addEventListener('wixDevelopersAnalyticsReady', registerListener);