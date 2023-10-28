
function gtag(){dataLayer.push(arguments);}
!function(w, a) {
    function config() {
            gtag('config', 'G-285SBVRMMD', { send_page_view: false });
    }
    if (!w.dataLayer) {
        w.dataLayer = w.dataLayer || [];
        gtag('js', new Date());
    }
    gtag('set', 'developer_id.dYzMzMD', true);
    config()
    w[a] = (w[a] && w[a].filter(c => c.name !== 'globalGtag')) || [];
    w[a].push({
        name: 'globalGtag',
        report: gtag,
        config: {
            trackingId: 'G-285SBVRMMD'
        }
    });
}(window,"promoteAnalyticsChannels")