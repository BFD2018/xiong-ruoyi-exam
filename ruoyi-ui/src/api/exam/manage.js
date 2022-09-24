import request from '@/utils/request'

// 查询考试管理列表
export function listManage(query) {
  return request({
    url: '/exam/manage/list',
    method: 'get',
    params: query
  })
}

// 查询考试管理详细
export function getManage(id) {
  return request({
    url: '/exam/manage/' + id,
    method: 'get'
  })
}

// 新增考试管理
export function addManage(data) {
  return request({
    url: '/exam/manage',
    method: 'post',
    data: data
  })
}

// 修改考试管理
export function updateManage(data) {
  return request({
    url: '/exam/manage',
    method: 'put',
    data: data
  })
}

// 删除考试管理
export function delManage(id) {
  return request({
    url: '/exam/manage/' + id,
    method: 'delete'
  })
}
