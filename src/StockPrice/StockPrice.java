package StockPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 *
 * 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
 *
 * 请你设计一个算法，实现：
 *
 * 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
 * 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
 * 找到当前记录里股票的 最高价格 。
 * 找到当前记录里股票的 最低价格 。
 * 请你实现 StockPrice 类：
 *
 * StockPrice() 初始化对象，当前无股票价格记录。
 * void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
 * int current() 返回股票 最新价格 。
 * int maximum() 返回股票 最高价格 。
 * int minimum() 返回股票 最低价格 。
 */
class StockPrice {

    private List<Integer> timestamp1;
    private List<Integer> price1;
    public StockPrice() {
        this.timestamp1 = new ArrayList<>();
        this.price1 = new ArrayList<>();
    }

    public void update(int timestamp, int price) {
        boolean flag = false;
        if(timestamp1.isEmpty()){
            timestamp1.add(timestamp);
            price1.add(price);
        }
        else if(timestamp1.contains(timestamp)){
            int index = timestamp1.indexOf(timestamp);
            price1.set(index,price);
        }
        else{
            for(Integer element : timestamp1){
                if(timestamp>element){
                    continue;
                }
                else {
                    int index = timestamp1.indexOf(element);
                    timestamp1.add(index,timestamp);
                    price1.add(index,price);
                    flag = true;
                    break;
                }

            }
            if(!flag){
                timestamp1.add(timestamp);
                price1.add(price);

            }
        }

    }

    public int current() {
        System.out.println(price1);
        if(price1.isEmpty()){
            return 0;
        }
        else {
            //System.out.println(price1.get(price1.size() - 1));
            return price1.get(price1.size() - 1);
        }
    }

    public int maximum() {
        return Collections.max(price1);
    }

    public int minimum() {
        return Collections.min(price1);

    }
}


/**
 * class StockPrice {
 *     int maxTimestamp;
 *     HashMap<Integer, Integer> timePriceMap;
 *     TreeMap<Integer, Integer> prices;
 *
 *     public StockPrice() {
 *         maxTimestamp = 0;
 *         timePriceMap = new HashMap<Integer, Integer>();
 *         prices = new TreeMap<Integer, Integer>();
 *     }
 *
 *     public void update(int timestamp, int price) {
 *         maxTimestamp = Math.max(maxTimestamp, timestamp);
 *         int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
 *         timePriceMap.put(timestamp, price);
 *         if (prevPrice > 0) {
 *             prices.put(prevPrice, prices.get(prevPrice) - 1);
 *             if (prices.get(prevPrice) == 0) {
 *                 prices.remove(prevPrice);
 *             }
 *         }
 *         prices.put(price, prices.getOrDefault(price, 0) + 1);
 *     }
 *
 *     public int current() {
 *         return timePriceMap.get(maxTimestamp);
 *     }
 *
 *     public int maximum() {
 *         return prices.lastKey();
 *     }
 *
 *     public int minimum() {
 *         return prices.firstKey();
 *     }
 * }
 */