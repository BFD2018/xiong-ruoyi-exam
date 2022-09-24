import request from '@/utils/request'

// 查询错题本列表
export function listBook(query) {
  return request({
    url: '/exam/book/list',
    method: 'get',
    params: query
  })
}

// 查询错题本详细
export function getBook(id) {
  return request({
    url: '/exam/book/' + id,
    method: 'get'
  })
}

// 新增错题本
export function addBook(data) {
  return request({
    url: '/exam/book',
    method: 'post',
    data: data
  })
}

// 修改错题本
export function updateBook(data) {
  return request({
    url: '/exam/book',
    method: 'put',
    data: data
  })
}

// 删除错题本
export function delBook(id) {
  return request({
    url: '/exam/book/' + id,
    method: 'delete'
  })
}
