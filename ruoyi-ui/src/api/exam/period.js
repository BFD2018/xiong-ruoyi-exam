import request from '@/utils/request'

// 查询课程章节列表
export function listPeriod(query) {
  return request({
    url: '/exam/period/list',
    method: 'get',
    params: query
  })
}

// 查询课程章节详细
export function getPeriod(id) {
  return request({
    url: '/exam/period/' + id,
    method: 'get'
  })
}

// 新增课程章节
export function addPeriod(data) {
  return request({
    url: '/exam/period',
    method: 'post',
    data: data
  })
}

// 修改课程章节
export function updatePeriod(data) {
  return request({
    url: '/exam/period',
    method: 'put',
    data: data
  })
}

// 删除课程章节
export function delPeriod(id) {
  return request({
    url: '/exam/period/' + id,
    method: 'delete'
  })
}
