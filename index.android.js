var { requireNativeComponent, PropTypes, View } = require('react-native');

var iface = {
    name: 'Circles',
    propTypes: {
    	...View.propTypes,
    	barColors: PropTypes.array,
		barWidth: PropTypes.number,
		blockCount: PropTypes.number,
		blockScale: PropTypes.number,
		contourColor: PropTypes.number,
		contourSize: PropTypes.number,
		delayMillis: PropTypes.number,
		fillColor: PropTypes.number,
		maxValue: PropTypes.number,
		rimColor: PropTypes.number,
		rimWidth: PropTypes.number,
		spinSpeed: PropTypes.number,
		startAngle: PropTypes.number,
		textScale: PropTypes.number,
		textSize: PropTypes.number,
		unit: PropTypes.string,
		unitScale: PropTypes.number,
		unitSize: PropTypes.number,
    },
};

module.exports = requireNativeComponent('RCTCircles', iface);