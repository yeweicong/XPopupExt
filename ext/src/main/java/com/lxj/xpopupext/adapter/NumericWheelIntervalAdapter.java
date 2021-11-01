package com.lxj.xpopupext.adapter;


import android.util.Log;

import com.contrarywind.adapter.WheelAdapter;

/**
 * Numeric Wheel adapter.
 */
public class NumericWheelIntervalAdapter extends NumericWheelAdapter {

	private int minValue;
	private int maxValue;
	private int intervalValue;

	/**
	 * Constructor
	 * @param minValue the wheel min value
	 * @param maxValue the wheel max value
	 */
	public NumericWheelIntervalAdapter(int minValue, int maxValue, int intervalValue) {
		super(minValue, maxValue);
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.intervalValue = intervalValue;
	}

	@Override
	public Object getItem(int index) {
		if (index >= 0 && index < getItemsCount()) {
			int value = minValue + index;
			if(value != 0 && intervalValue > 0){
				// 有间隔时间
//				value = Math.round((value / (float)intervalValue)) * intervalValue;
				value = index * intervalValue + minValue;
			}
			return value;
		}
		return 0;
	}

	@Override
	public int getItemsCount() {
		if(intervalValue > 0){
			return Math.round((maxValue - minValue) / (float)intervalValue) + 1;
		}
		return maxValue - minValue + 1;
	}
	
	@Override
	public int indexOf(Object o){
		try {
			if(intervalValue > 0){
				return Math.round(((int)o - minValue) / (float)intervalValue);
			}
			return (int)o - minValue;
		} catch (Exception e) {
			return -1;
		}

	}
}
