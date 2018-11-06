<template>
  <div class="hello">
    <el-row :gutter="20">
      <el-col :span="18" :offset="3">
        <el-table :border="true" :data="items">
          <el-table-column prop="name" label="描述"></el-table-column>
          <el-table-column prop="path" label="路径"></el-table-column>
          <el-table-column prop="timeout" label="延时"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="primary" @click="edit(scope.row)">编辑</el-button>
              <el-button type="danger" @click="del(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      items:[]
    }
  },
  methods:{
    query(){
      this.$axios.get('/mock/getAll').then((res)=>{
          this.items = res.data;
      })
    },
    edit(row){
      this.$router.push({name:'Code',params:{item:row} })
    },
    del(row){
      this.$axios.post('/mock/delete',row).then((res)=>{
        this.query();
      })
    }
  },
  mounted(){
    this.query();
  }
}
</script>

<style scoped>

</style>
