<template>
  <div>
    <div style="text-align: left; margin: 5px 10px">

      <!--查询-->
<!--      <el-select v-model="selectedTimeOption"-->
<!--                 placeholder="选择时间"-->
<!--                 size="mini"-->
<!--                 @change="changeStartTime"-->
<!--                 style="margin-left: 10px">-->
<!--        <el-option-->
<!--          v-for="item in ['今天', '最近三天', '本周', '本月', '最近三月', '今年', '全部']"-->
<!--          :key="item"-->
<!--          :label="item"-->
<!--          :value="item">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-col >-->
<!--        <el-date-picker type="date" placeholder="选择日期" v-model="searchParams.beginTime" style="width: 100px"></el-date-picker>-->
<!--      </el-col>-->
<!--      <el-input type="text"-->
<!--                style="width: 200px; "-->
<!--                placeholder="查询参数1"-->
<!--                size="mini"-->
<!--                v-model="searchParams.searchParam1" clearable>-->
<!--      </el-input>-->

<!--      <el-button size="mini" @click="clearSearchParams">-->
<!--        清空-->
<!--      </el-button>-->
<!--      <el-button size="mini" type="primary" @click="search">-->
<!--        查询-->
<!--      </el-button>-->
    </div>

    <!--列表-->
    <div style="margin: 0px 10px;text-align: left;">
      <el-table
        :data="orderInfoAdmins"
        stripe
        :default-sort="{prop: 'createTime', order: 'descending'}">
        <el-table-column prop="orderNo" label="订单号" sortable></el-table-column>
        <el-table-column prop="orderStatus" label="订单状态" sortable></el-table-column>
        <el-table-column prop="takeType" label="取餐方式" sortable></el-table-column>
        <el-table-column prop="addressDetail" label="收货地址" show-overflow-tooltip sortable></el-table-column>
        <el-table-column prop="goodsPreview" label="商品信息"></el-table-column>
        <el-table-column prop="goodsTotalNum" label="商品总数" sortable></el-table-column>
        <el-table-column prop="totalPrice" label="总价格" sortable>
          <template slot-scope="scope">{{'￥' + scope.row.totalPrice / 100}}</template>
        </el-table-column>
        <el-table-column prop="payPrice" label="支付金额" sortable>
          <template slot-scope="scope">{{'￥' + scope.row.payPrice / 100}}</template>
        </el-table-column>
        <el-table-column prop="verifyNum" label="取单号"></el-table-column>
        <el-table-column prop="wxPayTransactionId" label="微信订单号" ></el-table-column>
        <el-table-column prop="createTime" label="下单时间" sortable></el-table-column>
        <el-table-column prop="payTime" label="支付时间" show-overflow-tooltip sortable></el-table-column>
        <el-table-column prop="finishTime" label="完成时间" show-overflow-tooltip sortable></el-table-column>
        <el-table-column prop="userPhone" label="用户联系电话" show-overflow-tooltip></el-table-column>
        <el-table-column prop="receiver" label="取餐人" show-overflow-tooltip></el-table-column>
        <el-table-column prop="extraInfo" label="订单备注" show-overflow-tooltip></el-table-column>
      </el-table>

      <!--分页组件-->
      <el-row style="float: right">
        <el-pagination
          @current-change="changePageNo"
          @size-change="changePageSize"
          :current-page.sync="searchParams.pageNo"
          :page-sizes="[5, 10, 20, 30, 50, 100]"
          :page-size.sync="searchParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </el-row>

    </div>
  </div>
</template>

<script>
  import {
    getOrderInfoAdmins
  } from "@/api/modules/app/orderInfoAdminApi.js";

  export default {
    name: "orderInfoAdminComponent",
    data() {
      return {
        // 查询参数
        searchParams: {
          searchParam1: null,
          pageNo: 1,
          pageSize: 10
        },
        total: 0,
        orderInfoAdmins: []
      }
    },
    mounted() {
      this.getOrderInfoAdmins()
    },
    methods: {
      // 获取数据
      getOrderInfoAdmins() {
        let that = this;
        getOrderInfoAdmins(that.searchParams.pageNo, that.searchParams.pageSize).then(result => {
          that.orderInfoAdmins = result.data.records;
          that.total = result.data.total;
        })
      },
      // 切换页数
      changePageNo(pageNo) {
        this.searchParams.pageNo = pageNo;
        this.getOrderInfoAdmins()
      },
      // 改变页面大小
      changePageSize(pageSize) {
        this.searchParams.pageSize = pageSize;
        this.getOrderInfoAdmins()
      },
      // 清除查询参数
      clearSearchParams() {
        this.searchParams.searchParam1 = null;
      }
    }
  }
</script>
