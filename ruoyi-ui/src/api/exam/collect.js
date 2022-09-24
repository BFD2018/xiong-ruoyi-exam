import request from '@/utils/request'

// 查询题目收藏列表
export function listCollect(query) {
  return request({
    url: '/exam/collect/list',
    method: 'get',
    params: query
  })
}

// 查询题目收藏详细
export function getCollect(id) {
  return request({
    url: '/exam/collect/' + id,
    method: 'get'
  })
}

// 新增题目收藏
export function addCollect(data) {
  return request({
    url: '/exam/collect',
    method: 'post',
    data: data
  })
}

// 修改题目收藏
export function updateCollect(data) {
  return request({
    url: '/exam/collect',
    method: 'put',
    data: data
  })
}

// 删除题目收藏
export function delCollect(id) {
  return request({
    url: '/exam/collect/' + id,
    method: 'delete'
  })
}
