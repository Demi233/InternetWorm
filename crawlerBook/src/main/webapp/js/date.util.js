var DateUtil = {
	/**
	 * 字符串转时间戳
	 */
	time2Stamp : function(strTime) {
		var timestamp = Date.parse(new Date(strTime));
		return timestamp;
	},
	second2Time : function(second){
		if(second == null){
			return "00:00:00";
		}
		var hour = parseInt(second/3600);
		var minute = parseInt((second%3600)/60);
		var seconds = (second%3600)%60;
		if(hour < 10){
			hour = "0"+hour;
		}
		if(minute < 10){
			minute = "0"+minute;
		}
		if(seconds < 10){
			seconds = "0"+seconds;
		}
			return hour + ":" + minute + ":" + seconds;
		
	},
	stamp2Time : function(timestamp) {
		if (timestamp != 0) {
			var newDate = new Date();
			newDate.setTime(timestamp);
			return newDate.format('yyyy-MM-dd hh:mm');
		} else {
			return '';
		}
	},
	stamp2Date : function(timestamp) {
		if (timestamp != 0) {
			var newDate = new Date();
			newDate.setTime(timestamp);
			return newDate;
		} else {
			return '';
		}
	},
	getDateDiff:function(dateTimeStamp) {
		var minute = 1000 * 60;
		var hour = minute * 60;
		var day = hour * 24;
		var halfamonth = day * 15;
		var month = day * 30;
		var now = new Date().getTime();
		var diffValue = now - dateTimeStamp;
		if (diffValue < 0) {
			return;
		}
		var monthC = diffValue / month;
		var weekC = diffValue / (7 * day);
		var dayC = diffValue / day;
		var hourC = diffValue / hour;
		var minC = diffValue / minute;
		if (monthC >= 1) {
			result = "" + parseInt(monthC) + "月前";
		} else if (weekC >= 1) {
			result = "" + parseInt(weekC) + "周前";
		} else if (dayC >= 1) {
			result = "" + parseInt(dayC) + "天前";
		} else if (hourC >= 1) {
			result = "" + parseInt(hourC) + "小时前";
		} else if (minC >= 1) {
			result = "" + parseInt(minC) + "分钟前";
		} else
			result = "刚刚";
		return result;
	},

	getDateTimeStamp:function(dateStr) {
		return Date.parse(dateStr.replace(/-/gi, "/"));
	},
	getSpotNowDate:function(){
		var d = new Date();
		var month = (d.getMonth()+1);
		return d.getFullYear() + "." + (month<10?("0"+month):month) + "." + d.getDate();
	}
};

Date.prototype.format = function(format) {
	var date = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S+" : this.getMilliseconds()
	};
	if (/(y+)/i.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + '')
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in date) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k]
					: ("00" + date[k]).substr(("" + date[k]).length));
		}
	}
	return format;
}